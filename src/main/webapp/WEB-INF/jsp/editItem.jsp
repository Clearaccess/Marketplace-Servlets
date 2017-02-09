<!DOCTYPE html>
<html>

<head>
    <title>Edit Item</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/editItem.css">
</head>

<body>
    <%@ include file="toolbar.jsp" %>

    <div class="container">
        <form class="form-horizontal" id="form">
            <div class="form-group">
                <div class="row">
                    <label for="titleOfItem" class="col-sm-2 control-label">Title of item:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="titleOfItem" placeholder="Title of item" required autofocus>
                    </div>
                </div>
                <div class="row">
                    <label for="description" class="col-sm-2 control-label">Description:</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" rows=5 id="description"></textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <label for="startPrice" class="col-sm-2 control-label">Start price: </label>
                    <div class="col-sm-6">
                        <input type="number" min=0 class="form-control" id="startPrice" placeholder="Start price"step="0.05" required>
                    </div>
                </div>
                <fieldset>
                    <div class="row">
                        <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                        <div class="col-sm-6">
                            <input type="number" min=0 class="form-control" id="bidIncrement" placeholder="Bid increment" step="0.05" required>
                        </div>
                    </div>
                    <div class="row">
                        <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                        <div class="col-sm-6">
                            <input type="time" class="form-control" id="timeLeft" placeholder="Time left" required>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="form-group">
                <label for="buyItNow" class="col-sm-2 control-label">Buy It Now: </label>
                <div class="checkbox col-sm-1">
                    <label>
                        <input type="checkbox" value="buyItNow" id="buyItNow">
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <button type="submit" class="btn btn-primary btn-lg" id="save">Publish/ Save</button>
                    <button type="reset" class="btn btn-primary btn-lg" id="reset">Reset</button>
                </div>
            </div>
        </form>

    </div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/editItem/controlMain.js"></script>
</body>

</html>