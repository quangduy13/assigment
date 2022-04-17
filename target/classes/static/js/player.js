$(document).ready(function () {
    $("#player-form").submit(function (event) {
        if ( $("#playerName").val() == ''){
            alert("Please enter player name before submit")
        } else{
            add_player();
        }
    });
});

$(document).ready(function () {
    $("#random-point").click(function (event) {
        if ( $("#your-name").val() == ''){
            alert("Please enter player name before submit")
        } else{
            randomPoint();
        }
    });
});


function add_player(){// pass your data in method
    var playerName = {}
    playerName["playerName"] = $("#playerName").val();
    console.log(playerName)
    $.ajax({
        type: "POST",
        url: "/player/add",
        data: JSON.stringify(playerName),
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        success: function (data) {
            var name = data["user"];
            if (name == null){
                alert(data["message"]);
            } else {
               /* $("#player-form").css('visibility', 'hidden');
                $("#score").innerHTML = name;

                alert(data["message"]);
                $("#score").text()*/
                window.location = '/home/play?userName='+data["user"]["userName"];

                console.log("SUCCESS : ", data["user"]);
            }
        },

        error: function (e) {
            // error handler
            alert('Add player name fail: ' + e.responseText);
        }
    });
}

function randomPoint(){
    var playerName = {}
    playerName["playerName"] = $("#your-name").val();;
    console.log(playerName)
    $.ajax({
        type: "POST",
        url: "/player/random",
        data: JSON.stringify(playerName),
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        success: function (data) {
            var name = data["user"];
            if (name == null){
                alert(data["message"]);
            } else {
                location.reload();
            }
        },

        error: function (e) {
            // error handler
            alert('Add player name fail: ' + e.responseText);
        }
    });
}
