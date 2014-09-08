/* 
 * Copyright 2014 Alen Caljkusic.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zklogtool.web.components;

import java.io.File;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class OpenTransactionLogFileDialog extends CustomComponent {

    /*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
    @AutoGenerated
    private AbsoluteLayout mainLayout;
    @AutoGenerated
    private VerticalLayout verticalLayout_1;
    @AutoGenerated
    private Button openButton;
    @AutoGenerated
    private HorizontalLayout horizontalLayout_1;
    @AutoGenerated
    private CheckBox startFromLastCheckbox;
    @AutoGenerated
    private CheckBox followCheckbox;
    @AutoGenerated
    private TextField snapshotDirectoryLabel;
    @AutoGenerated
    private TextField transactionLogFileLabel;
    @AutoGenerated
    private TextField nameLabel;

    public OpenTransactionLogFileDialog(final TabSheet displayTabSheet,
            final Window windowHandle) {
        buildMainLayout();
        setCompositionRoot(mainLayout);
        
        openButton.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

                File transactionLogFile = new File(transactionLogFileLabel.getValue());
                File snapshotDir = new File(snapshotDirectoryLabel.getValue());

                if (!transactionLogFile.isFile() && !transactionLogFile.isDirectory()) {

                    transactionLogFileLabel.setComponentError(new UserError("IO problem"));
                    return;

                }

                if (snapshotDirectoryLabel.getValue() != null && !snapshotDirectoryLabel.getValue().isEmpty() && !snapshotDir.isDirectory()) {

                    snapshotDirectoryLabel.setComponentError(new UserError("IO problem"));
                    return;

                }

                TransactionLogView transactionLogView = new TransactionLogView(transactionLogFile, snapshotDir,
                        followCheckbox.getValue(), startFromLastCheckbox.getValue(), displayTabSheet, nameLabel.getValue());

                HorizontalLayout horizontalLayout = new HorizontalLayout();
                horizontalLayout.setCaption(nameLabel.getValue());
                horizontalLayout.addComponent(transactionLogView);
                horizontalLayout.setWidth("100%");
                horizontalLayout.setHeight("100%");
                Tab transactionLogTab = displayTabSheet
                        .addTab(horizontalLayout);
                transactionLogTab.setClosable(true);
                displayTabSheet.setSelectedTab(transactionLogTab);

                windowHandle.close();

            }

        });

    }

    @AutoGenerated
    private AbsoluteLayout buildMainLayout() {
        // common part: create layout
        mainLayout = new AbsoluteLayout();
        mainLayout.setImmediate(false);
        mainLayout.setWidth("100%");
        mainLayout.setHeight("100%");

        // top-level component properties
        setWidth("100.0%");
        setHeight("100.0%");

        // verticalLayout_1
        verticalLayout_1 = buildVerticalLayout_1();
        mainLayout.addComponent(verticalLayout_1, "top:0.0px;left:0.0px;");

        return mainLayout;
    }

    @AutoGenerated
    private VerticalLayout buildVerticalLayout_1() {
        // common part: create layout
        verticalLayout_1 = new VerticalLayout();
        verticalLayout_1.setImmediate(false);
        verticalLayout_1.setWidth("-1px");
        verticalLayout_1.setHeight("-1px");
        verticalLayout_1.setMargin(true);
        verticalLayout_1.setSpacing(true);

        // nameLabel
        nameLabel = new TextField();
        nameLabel.setCaption("Name");
        nameLabel.setImmediate(false);
        nameLabel.setWidth("-1px");
        nameLabel.setHeight("-1px");
        nameLabel.setRequired(true);
        verticalLayout_1.addComponent(nameLabel);

        // transactionLogFileLabel
        transactionLogFileLabel = new TextField();
        transactionLogFileLabel
                .setCaption("Transaction log file or directory containing transaction log files to open");
        transactionLogFileLabel.setImmediate(false);
        transactionLogFileLabel.setWidth("540px");
        transactionLogFileLabel.setHeight("-1px");
        transactionLogFileLabel.setRequired(true);
        verticalLayout_1.addComponent(transactionLogFileLabel);

        // snapshotDirectoryLabel
        snapshotDirectoryLabel = new TextField();
        snapshotDirectoryLabel
                .setCaption("Directory containing snapshot files");
        snapshotDirectoryLabel.setImmediate(false);
        snapshotDirectoryLabel.setWidth("540px");
        snapshotDirectoryLabel.setHeight("-1px");
        verticalLayout_1.addComponent(snapshotDirectoryLabel);

        // horizontalLayout_1
        horizontalLayout_1 = buildHorizontalLayout_1();
        verticalLayout_1.addComponent(horizontalLayout_1);

        // button_1
        openButton = new Button();
        openButton.setCaption("Open");
        openButton.setImmediate(true);
        openButton.setWidth("-1px");
        openButton.setHeight("-1px");
        verticalLayout_1.addComponent(openButton);

        return verticalLayout_1;
    }

    @AutoGenerated
    private HorizontalLayout buildHorizontalLayout_1() {
        // common part: create layout
        horizontalLayout_1 = new HorizontalLayout();
        horizontalLayout_1.setImmediate(false);
        horizontalLayout_1.setWidth("-1px");
        horizontalLayout_1.setHeight("-1px");
        horizontalLayout_1.setMargin(false);
        horizontalLayout_1.setSpacing(true);

        // followCheckbox
        followCheckbox = new CheckBox();
        followCheckbox.setCaption("Follow");
        followCheckbox.setImmediate(false);
        followCheckbox.setWidth("-1px");
        followCheckbox.setHeight("-1px");
        horizontalLayout_1.addComponent(followCheckbox);

        // startFromLastCheckbox
        startFromLastCheckbox = new CheckBox();
        startFromLastCheckbox.setCaption("Start from last transaction");
        startFromLastCheckbox.setImmediate(false);
        startFromLastCheckbox.setWidth("-1px");
        startFromLastCheckbox.setHeight("-1px");
        horizontalLayout_1.addComponent(startFromLastCheckbox);

        return horizontalLayout_1;
    }

}
