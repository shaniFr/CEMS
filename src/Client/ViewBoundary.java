package Client;

import java.util.ArrayList;

import Data.Exam;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class ViewBoundary {

    @FXML
    private Button btnBack;

    @FXML
    private TableView<?> tblView;
    
    /* shows message received by the server */
    public static void showMessage(Object msg) {
    	ArrayList<Exam> examTable = (ArrayList<Exam>)msg;
    	
    	/* todo: gui should show this table .. */
    	
    }
}
