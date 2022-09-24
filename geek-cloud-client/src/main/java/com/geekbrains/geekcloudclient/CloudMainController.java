package com.geekbrains.geekcloudclient;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CloudMainController implements Initializable {

    public ListView<String> serverView;
    public ListView<String> clientView;

    private String currentDirectory;
    public void sendToServer(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurrentDirectory(currentDirectory = System.getProperty("user.home"));
        fillView(clientView, getFiles(currentDirectory));
        clientView.setOnMouseClicked(event ->{
            if (event.getClickCount() == 2){
                String selected = clientView.getSelectionModel().getSelectedItem();
                File selectedFile = new File(currentDirectory + "/" + selected);
                if (selectedFile.isDirectory()){
                    setCurrentDirectory(currentDirectory + "/" + selected);
                }
            }
        });
    }
    private void setCurrentDirectory(String directory){
        currentDirectory = directory;
        fillView(clientView, getFiles((currentDirectory)));
    }
    private void fillView(ListView<String> view, List<String> data){
        view.getItems().clear();
        view.getItems().addAll(data);
    }

    private List<String> getFiles(String directory){
        //file.txt 125 b
        // dir [DIR]
        File dir = new File(directory);
        if (dir.isDirectory()){
            String[] list = dir.list();
            if (list != null){
             return Arrays.asList(list);
            }
        }
        return List.of();
    }
}
