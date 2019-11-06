import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaAddAluno {
    private Aluno aluno;

    public void show(){
        show(null, false);
    }

    public void show(Aluno aluno, boolean viewMode){
        this.aluno = aluno;
        FXMLLoader loader = new FXMLLoader();
        Pane graph = null;
        try{
            graph = loader.load(getClass().getResource("JanelaAddAluno.fxml").openStream());
            Scene scene = new Scene(graph, 400, 200);
            ControllerJanelaAddAluno controller = loader.getController();
            if(aluno != null){
                controller.setAluno(aluno);
                controller.disable(viewMode);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            this.aluno = controller.getAluno();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Aluno getAluno() {
        return aluno;
    }
}
