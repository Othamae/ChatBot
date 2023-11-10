package dev.othamae.chatbot.persistent;

import org.springframework.stereotype.Service;

import dev.othamae.chatbot.contacts.Conversation;
import dev.othamae.chatbot.contacts.ConversationLine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class RDS {

        @PersistenceContext
    private EntityManager entityManager;

@Transactional
    public void saveMessage(Conversation conversation, String text, String messageType) {
        ConversationLine conversationLine = new ConversationLine(
                conversation.getChatId(),
                conversation.getUsername(),
                conversation.getConversationState(),
                text,
                messageType
        );

        // Guarda la conversación utilizando JPA
        entityManager.persist(conversationLine);
    }
    // public void saveMessage(Conversation conversation, String text, String messageType) throws SQLException {
    //     Connection connection = null;
    //     PreparedStatement statement = null;

    //     SessionFactory sessionFactory = new Configuration()
    //             .addAnnotatedClass(ConversationLine.class)
    //             .configure("/hibernate.cfg.xml")
    //             .buildSessionFactory();
    //     Session session = sessionFactory.openSession();
    //     session.close();

    //     ConversationLine conversationLine = new ConversationLine(
    //             conversation.getChatId(),
    //             conversation.getUsername(),
    //             conversation.getConversationState(),
    //             text,
    //             messageType
    //     );

    //     try {
    //         // Create a connection to the database
    //         connection = DriverManager.getConnection(DbConfig.DB_URL, DbConfig.DB_USER, DbConfig.DB_PASS);

    //         // Create a prepared statement for the insert query
    //         String insertQuery = "INSERT INTO conversation_lines (chatId, userName, conversationState, message, messageType ) VALUES (?,?,?,?,?)";
    //         statement = connection.prepareStatement(insertQuery);

    //         // Set the values of the prepared statement parameters
    //         statement.setString(1, conversationLine.getChat_id());
    //         statement.setString(2, conversationLine.getUsername());
    //         statement.setString(3, conversationLine.getConversationState());
    //         statement.setString(4, conversationLine.getMessage());
    //         statement.setString(5, conversationLine.getMessageType());

    //         // Execute the insert statement
    //         statement.executeUpdate();
    //     } finally {
    //         // Close the statement and connection resources
    //         if (statement != null) {
    //             statement.close();
    //         }
    //         if (connection != null) {
    //             connection.close();
    //         }
    //     }
    // }


}