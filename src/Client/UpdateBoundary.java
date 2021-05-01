package Client;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateBoundary {

	int temp2;
	
    @FXML
    private Button btnBack;
    @FXML
    private Label lblExamDuration;

    @FXML
    private TextField txtExamID;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblExamID;

    @FXML
    private TextField txtNewDuration;

    public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("/Client/Update.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Update Exam");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    
    
    @FXML
    public void Save(ActionEvent event) throws Exception {
		/* send message to client controller */
    	try { 
    		   temp2 = Integer.parseInt(txtNewDuration.getText());
    	    } 
    	catch(NumberFormatException ex) {
    		System.err.println("Invalid string argument"); 
    	 }
    	     
    	char op,op1;
    	String str,str1;
        int flag2=1;
    	str= txtExamID.getText();
    	str1=txtNewDuration.getText();
    	
    	for (int i=0;i<str.length();i++)
    	{ 
		   op = str.charAt(i);
		   if(((int)op <48)||((int)op>57)){
			   /*Alert alert = new Alert(AlertType.INFORMATION);
	        	alert.setTitle("Wrong input");
	        	alert.setHeaderText("wrong input");
	        	alert.setContentText("you must enter only numbers!!");
	        	alert.showAndWait();*/
	        	flag2=0;
			   JOptionPane.showMessageDialog(null, "Enter numbers!(ExamID)");
	        	break;   
		   }
    	}
		  
    	for (int i=0;i<str1.length();i++)
	    	{ 
			   op1 = str1.charAt(i);
			   if(((int)op1 <48)||((int)op1>57)){
				   JOptionPane.showMessageDialog(null, "Enter numbers!(ExamID)");
		        	flag2=0;
		        	break;   
			   }
	    	}
  	
    	
    	if((txtExamID.getLength()!=6)&&(flag2==1)) {
    		/*Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Wrong input");
        	alert.setHeaderText(null);
        	alert.setContentText("Exam ID must be 6");
        	alert.showAndWait();*/
        	 JOptionPane.showMessageDialog(null, "Exam ID must be 6");
    	}
    	else if ((temp2<1)&&(flag2==1)) {
        	/*Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Wrong input");
        	alert.setHeaderText(null);
        	alert.setContentText("Positive numbers only");
        	alert.showAndWait();*/       
        	JOptionPane.showMessageDialog(null, "Positive numbers only");
        	}
        	
        	else if(flag2==1) {
    		String temp = "U" + "-" + this.txtExamID.getText() + "-" + this.txtNewDuration.getText() + "-";
    		System.out.println(this.getClass().getName() + "save : " + temp);
    		ClientUI.chat.accept(temp);}
  

    	
 
	}
    
    @FXML
	void backMain(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide(); //hide primary window
		MyClientBoundary mcb = new MyClientBoundary();
		Stage primaryStage = new Stage();
		try {
			mcb.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
