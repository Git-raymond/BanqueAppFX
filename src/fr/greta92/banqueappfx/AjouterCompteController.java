package fr.greta92.banqueappfx;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import fr.greta92.banqueappfx.model.Banque;
import fr.greta92.banqueappfx.model.Compte;
import fr.greta92.banqueappfx.model.SoldeInsuffisantException;
import javafx.application.Platform;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1>Controlleur de la view 'AjouterCompte.fxml'</h1>
 * 
 * <p>
 * Exercice 1: ajouter une methode permettant de recevoir l'objet banque dans
 * AjouterCompteController. Note: inspirez-vous du code de MainController
 * 
 * </p>
 * <p>
 * Exercice 2: ajouter une méthode permettant de gérer l'evenement de type
 * 'Action' sur le bouton 'Ajouter'. cette methode doit afficher un message
 * d'erreur si les données sont invalide sinon elle doit ajouter le compte dans
 * l'objet banque. Note: la méthode 'ouvrirCompte' de la Banque permet de créer
 * le compte
 * </p>
 * 
 * <p>
 * Exercice 3: ajouter une méthode permettant de gérer l'evenement de type
 * 'Action' sur le bouton 'Annuler'. cette methode doit fermer la fenetre
 * modale. Note: voici le code permettant de récuperer le stage depuis la
 * méthode callback
 * 
 * <pre>
 * Node node = (Node) event.getSource();
 * Stage thisStage = (Stage) node.getScene().getWindow();
 * thisStage.hide();
 * </pre>
 * </p>
 * 
 *
 */

public class AjouterCompteController {

	Banque banque;
	Compte compte;

	@FXML
	TextField titulaireNew;
	@FXML
	TextField soldeNew;
	@FXML
	Button ajouterCompteBtn;
	@FXML
	Button annulerCompteBtn;

	@FXML
	public void ajouterCompte(ActionEvent event) throws IOException {
		System.out.println(event);
		String titulaireNew = this.titulaireNew.getText();
		Double soldeNew = Double.valueOf(this.soldeNew.getText());
		try {
			this.banque.ouvrirCompte(titulaireNew, soldeNew);
			Alert alertAjout = new Alert(AlertType.INFORMATION);
			alertAjout.setContentText("Compte ajouté : " + titulaireNew);
			alertAjout.show();
		} catch (SoldeInsuffisantException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText(e.getMessage());
			alert.show();
		}
	}

	@FXML
	public void annulerCompte(ActionEvent event) {
		Node node = (Node) event.getSource();
		Stage thisStage = (Stage) node.getScene().getWindow();
		thisStage.hide();
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}
}
