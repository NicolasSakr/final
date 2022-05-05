<?php

include("db_info.php");

$fname = $_GET['fist_name'];
$lname = $_GET['last_name'];
$email = $_GET['email'];
$phoneNb = $_GET['tel_num'];

$res = mysqli_query($mysqli, "SELECT * FROM users WHERE id = """);
$res[] = $raw;
$json_respnse = json_encode($res);
echo $json_respnse;
exit();