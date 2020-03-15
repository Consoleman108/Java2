package homework4;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextArea chat;

    @FXML
    TextField message;

    public void sendMsg() {
        if(!message.getText().equals("")) {
            chat.appendText(message.getText() + "\n");
            message.clear();
            message.requestFocus();
        }
    }
}
