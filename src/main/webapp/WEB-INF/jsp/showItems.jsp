<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <jsp:directive.page import="to.User" />
    <jsp:directive.page import="to.Item" />
    <jsp:directive.page import="to.Bid" />
    <jsp:directive.page import="java.util.ArrayList" />
    <jsp:directive.page import="view.entities.ViewItem" />
    <html>

    <head>
        <title>Items</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="../css/showItems.css">
    </head>

    <body>
        <jsp:directive.include file="toolbar.jsp" />

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-offset-1 col-sm-11">
                    <form class="form-inline" method="GET" action="search">
                        <h3 class="form-signin-heading">Search parameters</h3>
                        <h5 class="form-signin-heading">Keyword:</h5>
                        <div class="form-group">
                            <label class="sr-only" for="inputKeyWord">Key word</label>
                            <input name="keyWord" type="text" class="form-control" id="inputKeyWord" placeholder="Key word">
                        </div>
                        <select name="field" class="form-control">
                            <option value="1">UID</option>
                            <option value="2">Title</option>
                            <option value="3">Description</option>
                        </select>
                        <button type="submit" class="btn btn-primary">Search</button>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12" id="pane">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active panes"><a href="showItems">Show All Items</a></li>
                        <li role="presentation" class="panes"><a href="showMyItems">Show My Items</a></li>
                        <li role="presentation" class="panes"><a href="editItem">Sell</a></li>
                    </ul>
                </div>
            </div>
            <div class="row"></div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <tbody>
                                <jsp:scriptlet>
                                    <![CDATA[
                                    ArrayList<ViewItem> items=(ArrayList<ViewItem>)request.getAttribute("items");
                                ]]>
                                </jsp:scriptlet>
                                <jsp:scriptlet>
                                    <![CDATA[
                                    for(int i=0;i<items.size();i++) {
                                ]]>
                                </jsp:scriptlet>
                                <tr>
                                    <td class="text-center">
                                        <jsp:expression> items.get(i).getItemId() </jsp:expression>
                                    </td>
                                    <td class="text-center">
                                        <jsp:expression> items.get(i).getTitle() </jsp:expression>
                                    </td>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                        <![CDATA[
                                            if(items.get(i).getDescription()!=null){
                                        ]]>
                                        </jsp:scriptlet>

                                        <jsp:expression> items.get(i).getDescription() </jsp:expression>

                                        <jsp:scriptlet>
                                        <![CDATA[
                                            }
                                        ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <td class="text-center">
                                        <jsp:expression> items.get(i).getFullNameSeller() </jsp:expression>
                                    </td>
                                    <td class="text-center">
                                        <jsp:expression> items.get(i).getStartPrice() </jsp:expression>
                                    </td>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                        <![CDATA[
                                            if(items.get(i).getBidIncrement()!=0.0){
                                        ]]>
                                        </jsp:scriptlet>

                                        <jsp:expression> items.get(i).getBidIncrement() </jsp:expression>

                                        <jsp:scriptlet>
                                        <![CDATA[
                                            }
                                        ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                        <![CDATA[
                                            if(items.get(i).getBestOffer()!=0.0){
                                        ]]>
                                        </jsp:scriptlet>

                                        <jsp:expression> items.get(i).getBestOffer() </jsp:expression>

                                        <jsp:scriptlet>
                                        <![CDATA[
                                            }
                                        ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                        <![CDATA[
                                            if(items.get(i).getFullNameBidder()!=null){
                                        ]]>
                                        </jsp:scriptlet>
                                        
                                        <jsp:expression> items.get(i).getFullNameBidder() </jsp:expression>

                                        <jsp:scriptlet>
                                        <![CDATA[
                                            }
                                        ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                            <![CDATA[
                                                 if(!items.get(i).isBuyItNow()) {
                                            ]]>
                                        </jsp:scriptlet>

                                        <jsp:expression> items.get(i).getStopDate() </jsp:expression>

                                        <jsp:scriptlet>
                                            <![CDATA[
                                                }
                                            ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <jsp:scriptlet>
                                        <![CDATA[
                                             if(items.get(i).isBuyItNow()) {
                                        ]]>
                                    </jsp:scriptlet>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                            <![CDATA[
                                                 if(session.getAttribute("user")!=null && ((User)session.getAttribute("user")).getUserId()!=items.get(i).getSellerId()) {
                                            ]]>
                                        </jsp:scriptlet>

                                        <jsp:directive.include file="biddingBuy.jsp" />

                                        <jsp:scriptlet>
                                            <![CDATA[
                                                 }
                                            ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <jsp:scriptlet>
                                        <![CDATA[
                                            } else {
                                        ]]>
                                    </jsp:scriptlet>
                                    <td class="text-center">
                                        <jsp:scriptlet>
                                            <![CDATA[
                                                 if(session.getAttribute("user")!=null && ((User)session.getAttribute("user")).getUserId()!=items.get(i).getSellerId()) {
                                            ]]>
                                        </jsp:scriptlet>

                                        <jsp:directive.include file="biddingDoBid.jsp" />

                                        <jsp:scriptlet>
                                            <![CDATA[
                                                 }
                                            ]]>
                                        </jsp:scriptlet>
                                    </td>
                                    <jsp:scriptlet>
                                        <![CDATA[
                                            }
                                        ]]>
                                    </jsp:scriptlet>
                                </tr>
                                <jsp:scriptlet> } </jsp:scriptlet>
                            </tbody>
                            <thead>
                                <tr class="info">
                                    <th class="text-center">Items</th>
                                    <th/>
                                    <th/>
                                    <th/>
                                    <th/>
                                    <th/>
                                    <th/>
                                    <th/>
                                    <th/>
                                    <th/>
                                </tr>
                                <tr>
                                    <th class="text-center">
                                        UID
                                    </th>
                                    <th class="text-center">
                                        Title
                                    </th>
                                    <th class="text-center">
                                        Description
                                    </th>
                                    <th class="text-center">
                                        Seller
                                    </th>
                                    <th class="text-center">
                                        Start price
                                    </th>
                                    <th class="text-center">
                                        Bid inc
                                    </th>
                                    <th class="text-center">
                                        Best offer
                                    </th>
                                    <th class="text-center">
                                        Bidder
                                    </th>
                                    <th class="text-center">
                                        Stop date
                                    </th>
                                    <th class="text-center">
                                        Bidding
                                    </th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/showItems/controlMain.js"></script>
    </body>

    </html>