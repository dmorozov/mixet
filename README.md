# Mixet

Mixet is a library aiming at easing application migration from GWT 2.x to GWT 3.0
.

## Facts

GWT 3.0 will :

- drop the `Widget` class and all the associated hierarchy,
- Javascript interoperability will be supported by JsInterop instead of JSNI,
- drop everything associated with GWT Generators : like GWT-RPC, UiBinder, I18N and so on.

GWT users have a lot of work to do in order to be able to migrate any big code base from pre and post GWT 3.0 versions.

For big projects, it is horrifying the amount of work needed to be done if one wants to switch to GWT 3.0.

## Mission

The Mixet library's purpose is to provide with a middle-way approach between staying on GWT 2.x versions and trying to migrate an application in a one-shot step (which is very difficult to acheive for big code base).

## Philosophy

Having dropped `gwt-user` from your project and by replacing it by `mixet`, one should have done 80% of the migration process.

- Mixet provides most of the legacy gwt widgets, but those are reimplemented over JsInterop and Elemental. This means that your application should compile and work with `mixet` in the same way as it was working with `gwt-user` widgets (mixet tries the best for that).
- Mixet implementation is based on new standards that are here to stay : GWT 3.0 paradigm, JsInterop, Elemental.
- Of course there are migration path that cannot be managed by mixet. Those should represent a minor part of the migration work.
- Mixet will allow you to mix Widgets and native HTMLElements. So a widget will be able to have a pure HTML Element as a child and a HTML Element should also be able to accept a widget as a child.

The first implementations of `mixet` are kind of laboratories in order to find something that works out well.

Later on, mixet will also be able to migrate other core parts of GWT : RPC, UiBinder, I18N and so on...

## Contributions

Contributions are of course welcome.