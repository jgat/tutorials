public int getUserCredits(String username) throws DatabaseException {
    Connection connection = getConnection();
    try {
        Statement statement = connection.createStatement(
            "SELECT * FROM CREDITS WHERE username=\"" + username + "\"");
        ResultSet resultSet = statement.executeQuery();
        int result = findCreditsForUser(username, resultSet);
        resultSet.close();
        statement.close();
        return result;
    } catch (SQLException e) {
        throw new DatabaseException("Unable to get credits", e);
    }
}
