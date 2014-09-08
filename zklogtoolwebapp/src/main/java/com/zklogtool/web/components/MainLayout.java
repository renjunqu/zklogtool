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

import java.io.IOException;
import java.util.Properties;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MainLayout extends CustomComponent {

    /*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_4;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_4;
	@AutoGenerated
	private Label versionLabel;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_3;
	@AutoGenerated
	private TabSheet tabSheet_1;
	@AutoGenerated
	private MenuBar menuBar_1;
	public MainLayout() {

        buildMainLayout();

        setCompositionRoot(mainLayout);
        
        versionLabel.setValue("zklogtoolwebapp "+projectVersion());

        MenuItem fileMenuItem = menuBar_1.addItem("File", null, null);

        fileMenuItem.addItem("Open transaction log", new MenuBar.Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {

                final Window window = new Window("Open transaction log file");
                window.setModal(true);

                OpenTransactionLogFileDialog openFileDialog = new OpenTransactionLogFileDialog(tabSheet_1, window);
                window.setHeight(300, Unit.PIXELS);
                window.setWidth(600, Unit.PIXELS);

                window.setContent(openFileDialog);
                UI.getCurrent().addWindow(window);

            }

        });

        fileMenuItem.addItem("Open snapshot", new MenuBar.Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {

                final Window window = new Window("Open snapshot file");
                window.setModal(true);

                OpenSnapshotFileDialog openFileDialog = new OpenSnapshotFileDialog(tabSheet_1, window);
                window.setHeight(250, Unit.PIXELS);
                window.setWidth(600, Unit.PIXELS);

                window.setContent(openFileDialog);
                UI.getCurrent().addWindow(window);

            }

        });

        MenuItem helpMenuItem = menuBar_1.addItem("Help", null, null);

        helpMenuItem.addItem("About", new MenuBar.Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {

                final Window window = new Window("About");
                window.setModal(true);

                final VerticalLayout verticalLayout = new VerticalLayout();
                verticalLayout.setMargin(true);
                verticalLayout.addComponent(new Label("This is zklogtool web front end in development"));

                window.setContent(verticalLayout);
                UI.getCurrent().addWindow(window);

            }

        });

    }
    
    private String projectVersion() {

        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/app.properties"));
        } catch (IOException ex) {         
            System.err.println("app.properties file is missing from classpath"); 
        }
        return properties.getProperty("application.version");
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
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		mainLayout.addComponent(verticalLayout_4,
				"top:0.0px;right:0.0px;bottom:6.0px;left:0.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("100.0%");
		verticalLayout_4.setHeight("100.0%");
		verticalLayout_4.setMargin(false);
		
		// menuBar_1
		menuBar_1 = new MenuBar();
		menuBar_1.setImmediate(false);
		menuBar_1.setWidth("100.0%");
		menuBar_1.setHeight("-1px");
		verticalLayout_4.addComponent(menuBar_1);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		verticalLayout_4.addComponent(verticalLayout_2);
		verticalLayout_4.setExpandRatio(verticalLayout_2, 1.0f);
		
		return verticalLayout_4;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("100.0%");
		verticalLayout_2.setHeight("100.0%");
		verticalLayout_2.setMargin(true);
		verticalLayout_2.setSpacing(true);
		
		// horizontalLayout_3
		horizontalLayout_3 = buildHorizontalLayout_3();
		verticalLayout_2.addComponent(horizontalLayout_3);
		verticalLayout_2.setExpandRatio(horizontalLayout_3, 1.0f);
		
		// horizontalLayout_4
		horizontalLayout_4 = buildHorizontalLayout_4();
		verticalLayout_2.addComponent(horizontalLayout_4);
		
		return verticalLayout_2;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_3() {
		// common part: create layout
		horizontalLayout_3 = new HorizontalLayout();
		horizontalLayout_3.setImmediate(false);
		horizontalLayout_3.setWidth("100.0%");
		horizontalLayout_3.setHeight("100.0%");
		horizontalLayout_3.setMargin(false);
		
		// tabSheet_1
		tabSheet_1 = new TabSheet();
		tabSheet_1.setImmediate(false);
		tabSheet_1.setWidth("100.0%");
		tabSheet_1.setHeight("100.0%");
		horizontalLayout_3.addComponent(tabSheet_1);
		
		return horizontalLayout_3;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_4() {
		// common part: create layout
		horizontalLayout_4 = new HorizontalLayout();
		horizontalLayout_4.setImmediate(false);
		horizontalLayout_4.setWidth("100.0%");
		horizontalLayout_4.setHeight("-1px");
		horizontalLayout_4.setMargin(false);
		
		// versionLabel
		versionLabel = new Label();
		versionLabel.setImmediate(false);
		versionLabel.setWidth("-1px");
		versionLabel.setHeight("-1px");
		versionLabel.setValue("zklogtool web application 0.1");
		horizontalLayout_4.addComponent(versionLabel);
		horizontalLayout_4.setComponentAlignment(versionLabel,
				new Alignment(34));
		
		return horizontalLayout_4;
	}

}
