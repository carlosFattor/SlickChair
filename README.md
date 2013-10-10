Work in progress
================

SlickChair is an open source conference management system written in Scala
using the Play Framework. This project uses several modern web technology to
provide the best experience to both the conference administrators and the end
users.

Screen-shots
------------


Getting Started
===============

Requirements
------------

To run SlickChair, you need the [Play Framework v2.1.1][1].


Testing locally
---------------

First download SlickChair sources from the [GitHub repository][2]. If you have
[Git][3] installed:

    git clone https://github.com/SlickChair/SlickChair

After that, move to the SlickChair directory and run the application with
Play:

    cd SlickChair
    play start

Note that the first execution might take a while as Play has to download all
the dependencies.

Once started, the application is accessible at [http://localhost:9000/][4].
The first person to log into SlickChair will obtain the chair privileges
(administrator). From there you will be able to navigate thought the
administration pages and get an idea of SlickChair functionalities.

[1]: http://www.playframework.com/documentation/2.1.1/Installing
[2]: https://github.com/SlickChair/SlickChair
[3]: http://git-scm.com/downloads
[4]: http://localhost:9000/
