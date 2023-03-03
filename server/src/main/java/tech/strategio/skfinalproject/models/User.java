package tech.strategio.skfinalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

    private String password;

    private String email;

    @Id
    private String id;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }



}
