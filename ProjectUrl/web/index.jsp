<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8" />
    <title>Purl - Pens Url Shortener</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css" media="all">
    <style>
        body {
            position: absolute;
            font-size: 1.1em;
            background-color: white;
            width: 100%;
            margin: 0;
            padding: 0;
        }

        img {
            max-width: 100%;
        }

        .form-short {
            background: linear-gradient(-90deg, #FF2B7F 0%, rgba(250, 0, 147, 0.03) 0%), url('images/bg.png');
            background-size: cover;
        }

        .clm-t-pad {
            border-top: #FF2B7F 1px solid;
        }

        .clm-b-pad {
            border-top: #FF2B7F 1px solid;
            border-bottom: #FF2B7F 1px solid;
        }

        .clm-lr {
            border-left: #FF2B7F 1px solid;
            border-right: #FF2B7F 1px solid;
        }

        .icn {
            width: 64px;
            height: 64px;
        }

        .frame-full {
            width: 100%;
            min-height: 100vh;
        }

        .box{
            padding: 40px 40px 40px 40px;
        }
    </style>

</head>

<body>

    <section class="section hero is-fullwidth is-fullheight form-short">
        <div class="hero-head has-text-centered">
        </div>
        <div class="hero-body">
            <div class="container content has-text-centered">
                <div class="columns is-12">
                    <div class="column is-3">
                    </div>
                    <div class="column is-6 box">
                        <h1 class="title is-1 has-text-danger">Purl - Pens Url Shortener</h1>
                        <form action="proses-short.jsp" method="GET">
                            <div class="columns">
                                <div class="column is-12">
                                    <input type="text" class="input is-danger" placeholder="Paste Url" name="url">
                                </div>
                            </div>
                            <div class="columns">
                                <div class="column is-6">
                                    <input type="text" class="input is-danger" placeholder="Custom (optional)" name="custom">
                                </div>
                                <div class="column is-6">
                                    <input type="text" class="input is-danger" placeholder="Password (optional)" name="password">
                                </div>
                            </div>
                            <input type="submit" class="button is-danger" value="Shorten">
                        </form>
                    </div>
                    <div class="column is-3">
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>