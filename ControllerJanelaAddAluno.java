import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerJanelaAddAluno {

    private Aluno aluno;

    @FXML TextField txtName;
    @FXML TextField txtAge;

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
        txtName.setText(aluno.getName());
        txtAge.setText(aluno.getAge()+"");
    }

    public Aluno getAluno() {
        if(aluno == null) aluno = new Aluno();
        aluno.setName(txtName.getText());
        aluno.setAge(Integer.parseInt(txtAge.getText()));
        return aluno;
    }

    public void save(ActionEvent actionEvent) {
        ((Stage)txtName.getScene().getWindow()).close();
    }

    public void disable(boolean viewMode){
        txtName.setDisable(viewMode);
        txtAge.setDisable(true);
    }
}
