package sample;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class FileCh {
    private FileChooser fileChooser;
    private Stage primaryStage;
    private File file;

    FileCh(FileChooser fileChooser, Stage stage){
        this.fileChooser = fileChooser;
        this.primaryStage = stage;
    }

    public void ActionWriter(String text, String fileName) throws MyException {
        try(FileWriter writer = new FileWriter(fileName))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException exc)
        {
            System.out.println(exc.getMessage());
            throw new MyException(exc.getLocalizedMessage());
        }
    }
    public void chooseFile() {
        file = fileChooser.showOpenDialog(primaryStage);
    }
    public String getFilePath() {
        return file.getAbsolutePath();
    }
}