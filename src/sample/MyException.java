package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * класс собственных исключений
 * @author nastyabaturkina
 *
 */
@SuppressWarnings("serial")
public class MyException extends Throwable
{
    static public String LogFileName;
    static TextArea forAction;

    private String msg;
    /**
     * конструктор с параметрами
     * @param _msg сообщение об ошибке
     */
    public MyException(String _msg) {
        msg = _msg;
    }

    public void Log ( ) {
        Log("");
    }

    /**
     * функция для добавления дополнительного текста ошибки и записи ошибок в файл
     * @param Text дополнительный текст ошибки
     */
    public void Log ( String Text )
    {
        msg += Text;
        if ( LogFileName != null ) {
            try
            {
                FileWriter fr = new FileWriter(LogFileName, true);
                fr.write("\t" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) + "\t" + msg + "\n\n");
                forAction.appendText("\nError: " + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) + "\t" + msg + "\n\n");
                fr.close();
            }
            catch ( IOException exc )
            {
                exc.getLocalizedMessage();
            }
        }
    }

}
