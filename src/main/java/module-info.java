module collision.collisionavoidancegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens collision.collisionavoidancegame to javafx.fxml;
    exports collision.collisionavoidancegame;
}