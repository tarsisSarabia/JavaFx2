/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarsissarabia.javafx1;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Person;

/**
 *
 * @author tarsi
 */
public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboboxPerson;

    @FXML
    private TextField txtId;
    @FXML
    private TextArea txtArea;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtemail;
    @FXML
    private Button btAll;
    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxPersonAction() {
        Person person = comboboxPerson.getSelectionModel().getSelectedItem();
//          for (int i = 0; i < comboboxPerson.getItems().size(); i++) {
        txtId.setText(Integer.toString(person.getId()));
        txtNome.setText(person.getName());
        txtemail.setText(person.getEmail());

//        }
    }

    @FXML
    public void onBtAllAction() {

        for (int i = 0; i < comboboxPerson.getItems().size(); i++) {
            txtArea.appendText(Integer.toString(comboboxPerson.getItems().get(i).getId()) + " ");
            txtArea.appendText(comboboxPerson.getItems().get(i).getName() + " ");
            txtArea.appendText(comboboxPerson.getItems().get(i).getEmail() + "\n");

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Tarsis", "tarsis@gmail.com"));
        list.add(new Person(2, "Aline", "aline@gmail.com"));
        list.add(new Person(3, "Isaac", "isaac@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        comboboxPerson.setItems(obsList);
        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };

        comboboxPerson.setCellFactory(factory);
        comboboxPerson.setButtonCell(factory.call(null));
    }
}
