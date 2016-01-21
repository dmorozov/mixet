package com.google.gwt.user.client.ui;

/**
 * A widget that implements this interface has a 'name' associated with it, allowing it to be used with
 * {@link FormPanel}. This property is the name that will be associated with the widget when its form is submitted.
 */
public interface HasName
{

	/**
	 * Sets the widget's name.
	 * 
	 * @param name
	 *        the widget's new name
	 */
	void setName(String name);

	/**
	 * Gets the widget's name.
	 * 
	 * @return the widget's name
	 */
	String getName();
}
