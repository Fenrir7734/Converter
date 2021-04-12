package com.fenrir.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import com.fenrir.converter.ConversionHistory;

public class HistoryController {

    @FXML public Button copyButton;
    @FXML private TextArea historyTextArea;

    @FXML
    private void initialize() {
        historyTextArea.setText(ConversionHistory.getConversionHistory());
        historyTextArea.setScrollTop(Double.MIN_VALUE);
        historyTextArea.setScrollLeft(Double.MIN_VALUE);
        historyTextArea.setEditable(false);
    }

    @FXML
    public void setCopyButton(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(historyTextArea.getText());
        clipboard.setContent(content);
    }
}