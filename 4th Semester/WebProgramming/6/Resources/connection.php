<?php
function OpenConnection(): mysqli
{
    return mysqli_connect("localhost", "root", "", "roombooking");
}

function CloseConnection(mysqli $con)
{
    $con->close();
}
?>