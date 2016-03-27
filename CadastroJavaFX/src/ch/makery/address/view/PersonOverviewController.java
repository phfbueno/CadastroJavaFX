package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import org.controlsfx.dialog.Dialogs;

import com.sun.javafx.scene.control.SelectedCellsMap;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;
    
    @FXML
    private void handleDeletePerson(){
    	int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
    	if (selectedIndex >= 0){
    		personTable.getItems().remove(selectedIndex);	
    	}else{
    		Dialogs.create()
    		.title("Nenhuma Seleção")
    		.masthead("Nenhuma Pessoa Selecionada")
    		.message("Por Favor, Selecione uma pessoa na tabela.")
    		.showWarning();
    		
    	}
    	
    	
    }
    

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Inicializa a tabela de pessoas com duas colunas.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        // Limpa os detalhes da pessoa.
        showPersonDetail(null);

        // Detecta mudanças de seleção e mostra os detalhes da pessoa quando houver mudança.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetail(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }

 private void showPersonDetail(Person person){
	 
	 if(person!= null){
		 
		 firstNameLabel.setText(person.getFirstName());
		 lastNameLabel.setText(person.getFirstName());
		 streetLabel.setText(person.getStreet());
		 postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
		 cityLabel.setText(person.getCity());
		 
	  }else {
		  
		  firstNameLabel.setText(" ");
		  lastNameLabel.setText(" ");
		  streetLabel.setText(" ");
		  postalCodeLabel.setText(" ");
		  cityLabel.setText(" ");
		  birthdayLabel.setText(" ");
	 }
	  
	 
 }
 

}
