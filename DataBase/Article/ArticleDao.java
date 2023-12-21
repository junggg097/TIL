package org.example.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// ArticleDao - Data Access Object
// 오롯이 데이터베이스를 다루는 역할이다.
public class ArticleDao {
    // 어떤 데이터베이스와의 연결을 나타내는 connection
    private final Connection connection;

    public ArticleDao(Connection connection) {
        this.connection = connection;
    }

    // 제목과 내용을 전달받으면
    // 데이터베이스에 새로운 게시글(article) 행을 만들고,
    // 성공 여부에 따라서 boolean을 반환한다.
    public boolean create(String title, String content) {
        /*
        -- article 테이블에 새로운 데이터를 넣어주는 SQL
        INSERT INTO article(title, content) VALUES ('title', 'content');
         */
        System.out.println("받은 제목: " + title);
        System.out.println("받은 내용: " + content);
        // Statement: JDBC에 전달하는 SQL문을 전달하는 역할
        // try - with - resources
        try (Statement statement = this.connection.createStatement()) {
            String insertSql = String.format("INSERT INTO article(title, content) VALUES ('%s', '%s');", title, content);
            System.out.println("준비된 SQL: " + insertSql);
            System.out.println(statement.executeUpdate(insertSql));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // 데이터베이스에 저장된 모든 글 정보를 List 형태로 반환한다.
    public List<ArticleDto> readAll() {
        /*
        -- article 테이블의 모든 데이터를 반환하는 SQL
        SELECT * FROM article;
         */

        System.out.println("모든 데이터 조회하기");
        try (Statement statement = this.connection.createStatement()) {
            String selectSql = "SELECT * FROM article;";
            ResultSet resultSet = statement.executeQuery(selectSql);
            // 여러개의 데이터를 돌려줄 예정이니,
            List<ArticleDto> articles = new ArrayList<>();

            // ResultSet 은 .next() 메서드를 통해 다음 줄을 확인하며,
            // 만일 다음 줄이 없으면 , .next() 의 결과는 false다
            while (resultSet.next()) {
                /*
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("title"));
                System.out.println(resultSet.getString("content"));
                */

                // resultSet의 데이터를 바탕으로 새로운 ArticleDto 객체를 만들자.
                ArticleDto article = new ArticleDto(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // PreparedStatement
    // 조회하고 싶은 게시글을 받고, 그 게시글을 객체의 형태로 반환하는 메서드
    public ArticleDto readOne(int id) {
        System.out.println("단일 데이터 조회하기");
        /*
        -- 특정 id인 article 행 조회
        SELECT * FROM article WHERE id = %d;
         */

        // PreparedStatement 는  SQL를 먼저 준비
        String selectSql = "SELECT * FROM article WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(selectSql)){
            statement.setInt(1,id);
            // 결과는 동일하게 ResultSet으로 받는다.
            ResultSet resultSet = statement.executeQuery();
            // ResulteSet을 사용한다.
            if (resultSet.next()) {
                return new ArticleDto(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        // 지금은  null 이지만 나아가면 Optional 사용 가능
        return null;
    }
}