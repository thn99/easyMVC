import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerJanelaGerenciaAluno {

    @FXML TableView<Aluno> table;
    @FXML TableColumn<Aluno, String> colName;
    @FXML TableColumn<Aluno, Integer> colAge;
    private ObservableList<Aluno> alunos;

    public void bindTable(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        load();
        table.setItems(alunos);
    }

    private void load(){
        alunos = FXCollections.observableArrayList();
        alunos.add(new Aluno("Zé", 55));
    }

    @FXML public void initialize(){
        bindTable();
    }

    public void add(ActionEvent actionEvent) {
        JanelaAddAluno janela = new JanelaAddAluno();
        Aluno teste = new Aluno("a", 4);
        janela.show();
        Aluno aluno = janela.getAluno();
        alunos.add(aluno);
    }

    public void remove(ActionEvent actionEvent) {
        alunos.remove(table.getSelectionModel().getSelectedItem());
    }

    public void visualize(ActionEvent actionEvent){
        Aluno aluno = table.getSelectionModel().getSelectedItem();
        JanelaAddAluno janela = new JanelaAddAluno();
        janela.show(aluno, false);

    }

    public void edit(ActionEvent actionEvent) {
        Aluno aluno = table.getSelectionModel().getSelectedItem();
        int index = table.getSelectionModel().getSelectedIndex();
        JanelaAddAluno janela = new JanelaAddAluno();
        janela.show(aluno, false);
        alunos.set(index, janela.getAluno());
        table.refresh();
    }
}
