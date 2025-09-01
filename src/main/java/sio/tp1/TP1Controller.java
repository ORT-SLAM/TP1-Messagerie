package sio.tp1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sio.tp1.Model.Message;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TP1Controller implements Initializable {
    @FXML
    private Button cmdEnvoyer;
    @FXML
    private Button cmdRecevoir;
    @FXML
    private Button cmdEnvoyerMessage;
    @FXML
    private AnchorPane apEnvoyer;
    @FXML
    private AnchorPane apRecevoir;
    @FXML
    private ListView lstExpediteurs;
    @FXML
    private ListView lstDestinataires;
    @FXML
    private TextField txtMessage;
    @FXML
    private Label lblTitre;
    @FXML
    private ComboBox cboDestinataires;
    @FXML
    private TreeView tvMessages;
    @FXML
    private HashMap<String, ArrayList<Message>> maMessagerie;

    @FXML
    public void menuClicked(Event event) {
        if(event.getSource() == cmdEnvoyer) {
            lblTitre.setText("TP1 : Messagerie / Envoyer");
            apEnvoyer.toFront();
        }
        else {
            lblTitre.setText("TP1 : Messagerie / Recevoir");
            apRecevoir.toFront();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTitre.setText("TP1 : Messagerie / Envoyer");
        apEnvoyer.toFront();
        lstExpediteurs.getItems().addAll("Enzo","Noa","Lilou","Milo");
        lstDestinataires.getItems().addAll("Enzo","Noa","Lilou","Milo");
        cboDestinataires.getItems().addAll("Enzo","Noa","Lilou","Milo");
        cboDestinataires.getSelectionModel().selectFirst();
        maMessagerie = new HashMap<>();
    }

    @FXML
    public void cmdEnvoyerMessageClicked(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur de l'envoi");
        alert.setHeaderText("");
        if(lstExpediteurs.getSelectionModel().getSelectedItem() == null) {
            alert.setContentText("Veuillez sélectionner un expéditeur.");
            alert.showAndWait();
        } else if (lstDestinataires.getSelectionModel().getSelectedItem() == null) {
            alert.setContentText("Veuillez sélectionner un destinataire.");
            alert.showAndWait();
        } else if (txtMessage.getText().isEmpty()) {
            alert.setContentText("Veuillez saisir un message.");
            alert.showAndWait();
        } else {
            String selectedExpediteur = lstExpediteurs.getSelectionModel().getSelectedItem().toString();
            String selectedDestinataire = lstDestinataires.getSelectionModel().getSelectedItem().toString();

            if (!maMessagerie.containsKey(selectedDestinataire)) {
                ArrayList<Message> messages = new ArrayList<>();
                maMessagerie.put(selectedDestinataire, messages);
            }

            Message message = new Message(selectedExpediteur, selectedDestinataire, txtMessage.getText());
            maMessagerie.get(selectedDestinataire).add(message);
        }
    }

    @FXML
    public void cboDestinatairesClicked(Event event) {
        TreeItem root = new TreeItem("Tous les messages");
        String selectedDestinataire = cboDestinataires.getSelectionModel().getSelectedItem().toString();
        if (maMessagerie.containsKey(selectedDestinataire)) {

        maMessagerie.get(selectedDestinataire).forEach(message -> {
            int i = maMessagerie.get(selectedDestinataire).indexOf(message) + 1;
            TreeItem number = new TreeItem("Message n°"+ i);
            TreeItem expediteur = new TreeItem("De ==> " + message.getExpediteur());
            TreeItem contenu = new TreeItem("Message ==> " + message.getContenuDuMessage());

            root.getChildren().add(number);
            number.getChildren().add(expediteur);
            number.getChildren().add(contenu);
            number.setExpanded(true);

        });
        } else {
            TreeItem emptyMessage = new TreeItem("Aucun message");
            root.getChildren().add(emptyMessage);
        }
        tvMessages.setRoot(root);
        root.setExpanded(true);


    }
}