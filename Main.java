package sample;

import com.sun.imageio.plugins.gif.GIFImageReader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Controller controller = new Controller();

        //设置中间面板
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5));
        String[] a = {"人民币","港元","澳门元","台币","欧元","美元","英镑","韩元","澳元","日元","加拿大元","俄罗斯卢布","泰国铢","菲律宾比索"};
        String[] b = {"CNY","HKD","MOP","TWD","EUR","USD","GBP","KRW","AUD","JPY","CAD","RUB","THB","PHP"};
        ObservableList<String> option1 = FXCollections.observableArrayList(a);
        ComboBox comboBox1 = new ComboBox(option1);
        comboBox1.setEditable(false);
        comboBox1.setValue("人民币");
        ObservableList<String> option2 = FXCollections.observableArrayList(a);
        ComboBox comboBox2 = new ComboBox(option2);
        comboBox2.setEditable(false);
        comboBox2.setValue("人民币");
        Button button = new Button("兑款");
        Text text1 = new Text("源货币：");
        Text text2 = new Text("目的货币：");
        Text text3 = new Text("兑款金额：");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField2.setEditable(false);
        gridPane.add(text1,0,0);
        gridPane.add(comboBox1,1,0);
        gridPane.add(text2,0,1);
        gridPane.add(comboBox2,1,1);
        gridPane.add(text3,0,2);
        gridPane.add(textField1,1,2);
        gridPane.add(button,0,3);
        gridPane.add(textField2,1,3);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String option1 = "人民币";
                String option2 = "人民币";
                double num = 0;
                for (int i=0;i<a.length;i++){
                    if (((String)comboBox1.getValue()).equals(a[i]))
                        option1 = b[i];
                    if (((String)comboBox2.getValue()).equals(a[i]))
                        option2 = b[i];
                }
                try {
                    num = Integer.parseInt(textField1.getText());
                }catch (Exception e){
                    num = 0;
                }finally {
                    textField2.setText(String.format("%.4f", controller.change(num,option1,option2)));
                }

            }
        });


        primaryStage.setTitle("货币转换");
        primaryStage.setScene(new Scene(gridPane, 300, 150));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
