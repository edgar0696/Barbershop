<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Add Client</legend>
        <form name="client" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Gender:<@spring.formInput "form.gender" "" "text"/>
            <br>
            Phone:<@spring.formInput "form.phone" "" "tel"/>
            <br>
            Adress:<@spring.formInput "form.adress" "" "text"/>
            <br>
            Birthday:<@spring.formInput "form.dateOfBirthday" "" "date"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>