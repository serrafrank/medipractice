$(document).ready(function () {
    var uuid;

    $('#recherche').autocomplete({
        source: function (requete, reponse) { // les deux arguments représentent les données nécessaires au plugin
            $.ajax({
                url: '/getDatafiles', // on appelle le script JSON
                dataType: 'json', // on spécifie bien que le type de données est en JSON
                data: {
                    value: $('#recherche').val() // on donne la chaîne de caractère tapée dans le champ de recherche
                },

                success: function (donnee) {
                    if (donnee.length > 0) {
                        reponse($.map(donnee, function (objet) {
                                $('#select').attr("disabled", false);
                                uuid = objet.id;
                                return objet.value;
                            }
                        ));
                    } else {
                        $('#select').attr("disabled", true);
                        return null;
                    }

                }
            })
            ;
        }
    });

    $('#select').click(
        $.ajax({
            url: '/setDatafile', // on appelle le script JSON
            dataType: 'json', // on spécifie bien que le type de données est en JSON
            data: {
                value: uuid // on donne la chaîne de caractère tapée dans le champ de recherche
            },

        }));
});
