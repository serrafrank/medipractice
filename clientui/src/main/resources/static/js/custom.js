$(document).ready(function () {

    $('#findFile').autocomplete({
        source: function (requete, reponse) { // les deux arguments représentent les données nécessaires au plugin
            $.ajax({
                url: '/getDatafiles', // on appelle le script JSON
                dataType: 'json', // on spécifie bien que le type de données est en JSON
                data: {
                    value: $('#findFile').val() // on donne la chaîne de caractère tapée dans le champ de findFile
                },

                success: function (donnee) {
                    if (donnee.length > 0) {
                        reponse($.map(donnee, function (objet) {
                                $('#submit').attr("disabled", false);
                                $('#datafileId').val(objet.id);
                                return objet.value;
                            }
                        ));
                    } else {
                        $('#submit').attr("disabled", true);
                        return null;
                    }

                }
            })
            ;
        }
    });

});
