package fr.lteconsulting.hexa.mixet.sampleapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		TextBox tb = new TextBox();
		MonLabel label = new MonLabel("Taper quelque chose puis cliquer...");
		Button button = new Button("Bonjour !");
		ListBox lb = new ListBox();

		// Java 7 code style
		button.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				label.setText(tb.getText());
				lb.setSelectedIndex(3);
			}
		});

		for (int i = 0; i < 10; i++)
			lb.addItem("item-" + i, "VALUE[" + i + "]");

		// Java 8 code style (use lambdas)
		lb.addChangeHandler((event) ->
				Window.alert("Changed ! index:" + lb.getSelectedIndex() + " itemText:" + lb.getSelectedItemText()
						+ " value:" + lb.getSelectedValue()));

		HorizontalPanel hp = new HorizontalPanel();
		hp.add(button);
		hp.add(lb);

		VerticalPanel panel = new VerticalPanel();
		panel.add(label);
		panel.add(tb);
		panel.add(hp);

		RootPanel.get().add(panel);
	}
}

class MonLabel extends Composite
{
	private Label internal;

	public MonLabel(String label)
	{
		internal = new Label(label);
		initWidget(internal);
	}

	public void setText(String text)
	{
		internal.setText(text);
	}
}
