package ru.itis.work_with_db.JDBC_test;

import java.sql.*;

public class SimpleDb {

    public static void main(String[] args) throws SQLException {
        SimpleDb m = new SimpleDb();
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bank_db";
            String login = "postgres";
            String password = "12345";
            Connection con = DriverManager.getConnection(url, login, password);
            con.setAutoCommit(false);
            for (int i = 6; i < 10; i++) {
                m.insert(con,i,"test" + i, "test2" + i, "1234567890", "test2" + i);
            }
            con.commit();
            con.setAutoCommit(true);
            m.select(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createTable(Connection con) throws SQLException {
        Statement statement = null;
        String createTableSQL = "CREATE TABLE public.test(test_id integer NOT NULL UNIQUE, first_name character varying(50) NOT NULL, last_name character varying(50) NOT NULL, phone character varying(50) NOT NULL, email character varying(50) NOT NULL)";
        try {
            statement = con.createStatement();
            // выполнить SQL запрос
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    private void dropTable(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        String createTableSQL = "DROP TABLE test";
        try {
            // выполнить SQL запрос
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    private void insert(Connection con, Integer id, String firstName, String lastName, String phone, String email) throws SQLException {

        long testId = -1;
        String res = null;

        PreparedStatement stmt = con.prepareStatement("INSERT INTO TEST (TEST_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL) VALUES (?, ?, ?, ?, ?)", new String[] {"test_id", "phone"});
        stmt.setInt(1,id);
        stmt.setString(2, firstName);
        stmt.setString(3, lastName);
        stmt.setString(4, phone);
        stmt.setString(5, email);
        stmt.executeUpdate();

        ResultSet gk = stmt.getGeneratedKeys();
        if(gk.next()) {
            // Получаем поле contact_id
            testId = gk.getLong("test_id");
            res = gk.getString("phone");
        }
        stmt.close();

        System.out.println("Результат вставки: " + testId + " " + res);
        stmt.close();
    }

    private void select(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM TEST");
        while (rs.next()) {
            String str = rs.getString("test_id") + ":" + rs.getString(2);
            System.out.println("Contact:" + str);
        }
        rs.close();
        stmt.close();
    }
}

