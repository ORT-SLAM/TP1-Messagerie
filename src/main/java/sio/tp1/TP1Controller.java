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
    private AnchorPane apEnvoyer;
    @FXML
    private AnchorPane apRecevoir;
    @FXML
    private Label lblTitre;
    @FXML
    private ListView lstExpediteurs;
    @FXML
    private ListView lstDestinataires;
    @FXML
    private TextField txtMessage;
    @FXML
    private Button cmdEnvoyerMessage;

    private HashMap<String, ArrayList<Message>> maMessagerie;
    @FXML
    private ComboBox cboDestinataires;
    @FXML
    private TreeView tvMessages;

    @FXML
    public void menuClicked(Event event) {
        if(event.getSource() == cmdEnvoyer)
        {
            lblTitre.setText("TP1 : Messagerie / Envoyer");
            apEnvoyer.toFront();
        }
        else//if(event.getSource() == cmdRecevoir)
        {
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

    }

    @FXML
    public void cboDestinatairesClicked(Event event) {




    }
}