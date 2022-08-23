package controller;

import model.Model;
import view.Viewer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener {

    private final Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        model.doAction(command);
    }
}