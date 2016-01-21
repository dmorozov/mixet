package fr.lteconsulting.hexa.mixet.sampleapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		final TextBox tb = new TextBox();
		final Label label = new Label("Taper quelque chose puis cliquer...");
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

		RootPanel.get().add(label);
		RootPanel.get().add(tb);
		RootPanel.get().add(button);
	}
}
