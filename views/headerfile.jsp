<!DOCTYPE html>
<html lang="en">

<head>
    <style>
        #topnav {
            background-color: #e7e7e7;
            margin-left: auto;
            margin-right: auto;
            width: 100%;
            height: 75px;
        }

        .header-container {
            width: 100%;
            height: 100%;
        }

        .left-header {
            height: 75px;
            color: #f2f2f2;
            vertical-align: middle;
            float: left;
            padding-left: 12px;
            padding-right: 12px;
        }

        #right-header {
            width: 350px;
            vertical-align: middle;
            height: 75px;
            text-align: right;
            float: right;
            padding-left: 12px;
            padding-right: 12px;
            margin-top: calc(28px - 0.5em);
        }

        .smallmenu {
            overflow: hidden;
            background-color: midnightblue;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 100%;
            height: 50px;
            top: 0;
            float: left;
        }

        .smallmenuheader {
            width: 70%;
            vertical-align: middle;
            float: left;
            clear: both;
            margin-left: 20px;
            margin-top: calc(15px - 0.5em);
            text-decoration: none;

        }

        .logo-content {
            vertical-align: middle;
            height: 50px !important;
            width: 150px !important;
        }

        a {
            text-decoration: none !important;
        }

        .dropdown-item {
            color: gold;
        }

        .dropdown-position {
            left: -95px;
            top: 37px;
        }

        @media (max-width: 768px) {
            .about {
                position: relative;
                top: 15px;
            }

            #right-header {
                max-width: 50px;
            }

            .user {
                display: none;
            }
        }
    </style>