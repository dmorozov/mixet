package com.google.gwt.user.client.ui;

import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

import elemental.events.Event;
import elemental.events.EventListener;
import elemental.js.JsBrowser;
import elemental.js.dom.JsElement;
import elemental.js.html.JsOptionElement;
import elemental.js.html.JsSelectElement;

public class ListBox extends Widget implements HasName, HasChangeHandlers
{
	private static final int INSERT_AT_END = -1;

	public ListBox()
	{
		this(JsBrowser.getDocument().createSelectElement());
		setStyleName("gwt-ListBox");
	}

	protected ListBox(JsElement element)
	{
		setElement(element);
		SelectElement.as(element);
	}

	/**
	 * Sets whether this list allows multiple selections. <em>NOTE:
	 * Using this method can spuriously fail on Internet Explorer 6.0.</em>
	 *
	 * @param multiple
	 *        <code>true</code> to allow multiple selections
	 */
	public void setMultipleSelect(boolean multiple)
	{
		((JsSelectElement)getElement()).setMultiple(multiple);
	}

	@Override
	public HandlerRegistration addChangeHandler(ChangeHandler handler)
	{
		getElement().addEventListener("change", new EventListener()
		{
			@Override
			public void handleEvent(Event evt)
			{
				handler.onChange(null);
			}
		}, false);

		return null;
	}

	/**
	 * Adds an item to the list box. This method has the same effect as
	 * 
	 * <pre>
	 * addItem(item, item)
	 * </pre>
	 * 
	 * @param item
	 *        the text of the item to be added
	 */
	public void addItem(String item)
	{
		insertItem(item, INSERT_AT_END);
	}

	/**
	 * Adds an item to the list box, specifying an initial value for the item.
	 * 
	 * @param item
	 *        the text of the item to be added
	 * @param value
	 *        the item's value, to be submitted if it is part of a {@link FormPanel}; cannot be <code>null</code>
	 */
	public void addItem(String item, String value)
	{
		insertItem(item, value, INSERT_AT_END);
	}

	/**
	 * Removes all items from the list box.
	 */
	public void clear()
	{
		((JsSelectElement)getElement()).setInnerHTML("");
	}

	/**
	 * Gets the number of items present in the list box.
	 * 
	 * @return the number of items
	 */
	public int getItemCount()
	{
		return ((JsSelectElement)getElement()).getOptions().getLength();
	}

	/**
	 * Gets the text associated with the item at the specified index.
	 * 
	 * @param index
	 *        the index of the item whose text is to be retrieved
	 * @return the text associated with the item
	 * @throws IndexOutOfBoundsException
	 *         if the index is out of range
	 */
	public String getItemText(int index)
	{
		return ((JsOptionElement)(((JsSelectElement)getElement()).getOptions().item(index))).getText();
	}

	/**
	 * Gets the text for currently selected item. If multiple items are selected, this method will return the text of the
	 * first selected item.
	 *
	 * @return the text for selected item, or {@code null} if none is selected
	 */
	public String getSelectedItemText()
	{
		int index = getSelectedIndex();
		return index == -1 ? null : getItemText(index);
	}

	@Override
	public String getName()
	{
		return ((JsSelectElement)getElement()).getName();
	}

	@Override
	public void setName(String name)
	{
		((JsSelectElement)getElement()).setName(name);
	}

	/**
	 * Gets the currently-selected item. If multiple items are selected, this method will return the first selected item
	 * ({@link #isItemSelected(int)} can be used to query individual items).
	 * 
	 * @return the selected index, or <code>-1</code> if none is selected
	 */
	public int getSelectedIndex()
	{
		return ((JsSelectElement)getElement()).getSelectedIndex();
	}

	/**
	 * Gets the value associated with the item at a given index.
	 * 
	 * @param index
	 *        the index of the item to be retrieved
	 * @return the item's associated value
	 * @throws IndexOutOfBoundsException
	 *         if the index is out of range
	 */
	public String getValue(int index)
	{
		return ((JsOptionElement)(((JsSelectElement)getElement()).getOptions().item(index))).getValue();
	}

	/**
	 * Gets the value for currently selected item. If multiple items are selected, this method will return the value of
	 * the first selected item.
	 *
	 * @return the value for selected item, or {@code null} if none is selected
	 */
	public String getSelectedValue()
	{
		int index = getSelectedIndex();
		return index == -1 ? null : getValue(index);
	}

	/**
	 * Gets the number of items that are visible. If only one item is visible, then the box will be displayed as a
	 * drop-down list.
	 * 
	 * @return the visible item count
	 */
	public int getVisibleItemCount()
	{
		return ((JsSelectElement)getElement()).getSize();
	}

	/**
	 * Inserts an item into the list box. Has the same effect as
	 * 
	 * <pre>
	 * insertItem(item, item, index)
	 * </pre>
	 * 
	 * @param item
	 *        the text of the item to be inserted
	 * @param index
	 *        the index at which to insert it
	 */
	public void insertItem(String item, int index)
	{
		insertItem(item, item, index);
	}

	/**
	 * Inserts an item into the list box, specifying its direction and an initial value for the item. If the index is
	 * less than zero, or greater than or equal to the length of the list, then the item will be appended to the end of
	 * the list.
	 * 
	 * @param item
	 *        the text of the item to be inserted
	 * @param value
	 *        the item's value, to be submitted if it is part of a {@link FormPanel}.
	 * @param index
	 *        the index at which to insert it
	 */
	public void insertItem(String item, String value, int index)
	{
		JsSelectElement select = (JsSelectElement)getElement();

		JsOptionElement option = JsBrowser.getDocument().createOptionElement();
		option.setInnerText(item);
		option.setValue(value);

		int itemCount = select.getLength();
		if (index < 0 || index > itemCount)
		{
			index = itemCount;
		}
		if (index == itemCount)
		{
			select.add(option, null);
		}
		else
		{
			JsOptionElement before = (JsOptionElement)select.getOptions().item(index);
			select.add(option, before);
		}
	}

	/**
	 * Sets whether an individual list item is selected.
	 * 
	 * <p>
	 * Note that setting the selection programmatically does <em>not</em> cause the
	 * {@link ChangeHandler#onChange(ChangeEvent)} event to be fired.
	 * </p>
	 * 
	 * @param index
	 *        the index of the item to be selected or unselected
	 * @param selected
	 *        <code>true</code> to select the item
	 * @throws IndexOutOfBoundsException
	 *         if the index is out of range
	 */
	public void setItemSelected(int index, boolean selected)
	{
		((JsOptionElement)(((JsSelectElement)getElement()).getOptions().item(index))).setSelected(selected);
	}

	/**
	 * Sets the text associated with the item at a given index.
	 * 
	 * @param index
	 *        the index of the item to be set
	 * @param text
	 *        the item's new text
	 * @param dir
	 *        the item's direction.
	 * @throws IndexOutOfBoundsException
	 *         if the index is out of range
	 */
	public void setItemText(int index, String text)
	{
		if (text == null)
			throw new NullPointerException("Cannot set an option to have null text");

		((JsOptionElement)(((JsSelectElement)getElement()).getOptions().item(index))).setText(text);
	}

	/**
	 * Sets the currently selected index.
	 * 
	 * After calling this method, only the specified item in the list will remain selected. For a ListBox with multiple
	 * selection enabled, see {@link #setItemSelected(int, boolean)} to select multiple items at a time.
	 * 
	 * <p>
	 * Note that setting the selected index programmatically does <em>not</em> cause the
	 * {@link ChangeHandler#onChange(ChangeEvent)} event to be fired.
	 * </p>
	 *
	 * @param index
	 *        the index of the item to be selected
	 */
	public void setSelectedIndex(int index)
	{
		((JsSelectElement)getElement()).setSelectedIndex(index);
	}

	/**
	 * Sets the value associated with the item at a given index. This value can be used for any purpose, but is also what
	 * is passed to the server when the list box is submitted as part of a {@link FormPanel}.
	 * 
	 * @param index
	 *        the index of the item to be set
	 * @param value
	 *        the item's new value; cannot be <code>null</code>
	 * @throws IndexOutOfBoundsException
	 *         if the index is out of range
	 */
	public void setValue(int index, String value)
	{
		((JsOptionElement)(((JsSelectElement)getElement()).getOptions().item(index))).setValue(value);
	}

	/**
	 * Sets the number of items that are visible. If only one item is visible, then the box will be displayed as a
	 * drop-down list.
	 * 
	 * @param visibleItems
	 *        the visible item count
	 */
	public void setVisibleItemCount(int visibleItems)
	{
		((JsSelectElement)getElement()).setSize(visibleItems);
	}
}
