package xyz.polarfrann.ooplanner;
/*
    FXController class for OOPlanner
    Created on 21/08/2020 at 14:45
    by frann
*/

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FXController {

    @FXML
    TreeView<String> explorer;

    @FXML
    public void initialize() {
    fillTree();
    }
    /*
        Dummy tree for testing purposes
     */
    public void fillTree() {
        TreeItem<String> projectFolder = new TreeItem<>("Project Name");
        projectFolder.setExpanded(true);
        addToTree(projectFolder);
        explorer.setRoot(projectFolder);

    }
    public void addToTree(TreeItem<String> item) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/home/frann/Code/"))) {
            for (Path path : directoryStream) {
                TreeItem<String> newItem = new TreeItem<>(path.toString().substring(path.toString().lastIndexOf("/")));
                newItem.setExpanded(true);
                item.getChildren().add(newItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
