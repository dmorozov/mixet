package fr.lteconsulting.hexa.mixet.sampleapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
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

		// code lambda
		button.addClickHandler((e) -> label.setText(tb.getText()));

		// same code with java 7
		// button.addClickHandler(new ClickHandler()
		// {
		// @Override
		// public void onClick(ClickEvent event)
		// {
		// label.setText(tb.getText());
		// }
		// });

		VerticalPanel panel = new VerticalPanel();
		panel.add(label);
		panel.add(tb);
		panel.add(button);

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
