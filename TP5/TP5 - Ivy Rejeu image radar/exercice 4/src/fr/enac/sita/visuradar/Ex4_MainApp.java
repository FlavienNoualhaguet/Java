package fr.enac.sita.visuradar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;

import fr.enac.sita.visuradar.view.views.View;
import fr.enac.sita.visuradar.data.param.VisualParametersManager;
import fr.enac.sita.visuradar.model.Model;

/**
 * Classe principale de l'application
 *
 * @author Benjamin Deslandes, Nicolas Saporito
 */
public class Ex4_MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // Créer la vue
        View view = new View();
        Scene scene = new Scene(view);
        stage.setTitle("VisuRadarCommunicationTests");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        
        // Lancer ici la communication avec rejeu
        // ...
    }

    @Override
    public void stop() {
        // Arr?ter ici la communication avec rejeu
        // ...
        
        // Sauvegarder les param?tres visuels
        try {
            VisualParametersManager.save(Model.INSTANCE.param);
        } catch (JAXBException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Echec sauvegarde des param?tres");
            alert.setHeaderText(null);
            alert.setContentText("Les param?tres de l'application VisuRadarJavaFX n'ont pas pu ?tre sauvegardés. \n"
                    + "Si ils ont été modifiés, leur nouvelle valeur est perdue.\n"
                    + "Ils seront réinitialisés ? leur valeur par défaut au prochain lancement.");
            alert.showAndWait();
        }
    }

    /**
     * Fonction main de l'application
     *
     * @param args Arguments de l'application JavaFX
     */
    public static void main(String[] args) {
        launch(args);
    }

}
