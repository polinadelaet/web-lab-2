function clicked(event) {

    if ($('input[name="coordinateR"]:checked').val() !== undefined) {
    /*let target = event.target.closest("div");
    let rect = target.getBoundingClientRect();
    let r = $('input[name="coordinateR"]:checked').val();

    let coordX = (event.clientX - rect.left - 22);
    let coordY = event.clientY - rect.top - 22;
    let x = ((event.x - rect.left) - 150) * Number(r) / 100 - 0.84;
    let y = (150 - (event.y - rect.top)) * Number(r) / 100 + 0.88;
    console.log(x.toFixed(2), y.toFixed(2));
    let svg = document.querySelector('svg');
    let kekx = x.toFixed(2);
    let keky = y.toFixed(2);*/



    let target = event.target.closest("div");
    let rect = target.getBoundingClientRect();
    let coordX = (event.clientX - rect.left - 22);
    let coordY = event.clientY - rect.top - 22;


    let svg = document.querySelector('svg');
    let r = $('input[name="coordinateR"]:checked').val();
    let rectt = event.currentTarget.getBoundingClientRect();
    let x = event.clientX - rectt.left;
    let y = event.clientY - rectt.top;
    let basis = 100 / r;
    let kekx = ((x - 150) / basis);
    let keky = ((150 - y) / basis);







    svg.insertAdjacentHTML("beforeend", `<circle r="3" cx="${coordX}" cy="${coordY}" fill-opacity="0.7" fill="red" stroke="firebrick"></circle>`);

    let form = document.createElement('form');
    form.action = "/web-lab-2-1.0/controller";
    form.method = 'POST';

    form.innerHTML = (`<input type="hidden" name="coordinateX" value="${kekx}"> 
                        <input type="hidden" name="coordinateY" value="${keky}"> 
                        <input type="hidden" name="coordinateR" value="${r}">`);

    document.body.append(form);

    form.submit();
    }

}


$(function () {

    let locationX = $('#tableWithResults tr:last td:first').attr("id");
    //let locationX = document.querySelectorAll('table tr:last');
    //let locationY = $('#locationY').text();
    let locationY = $("#tableWithResults tr:last td[class='y']").attr("id");
    let locationR = $("#tableWithResults tr:last td[class='r']").attr("id");
    let x = (Number(locationX) + 0.84) * 100 / Number(locationR) + 150 - 55 + 33;

    let y = 130 - (locationY - 0.88) * 100 / Number(locationR);


    let svg = document.querySelector('svg');




    svg.insertAdjacentHTML("beforeend", `<circle r="3" cx="${x}" cy="${y}" fill-opacity="0.7" fill="red" stroke="firebrick"></circle>`);


    svg.addEventListener("click", clicked);


    $('#checkForm').submit(function (e) {

        var coordinateY = $('#coordinateY').val();
        var coordinateR = $('input[name="coordinateR"]:checked').val();

        $('#coordinateY').next("div").remove();
        $('.coordinateRE').next("div").remove();

        if (isNaN((coordinateY - 0)) || coordinateY < -3 || coordinateY > 5 || coordinateY === '') {
            e.preventDefault();
            if (coordinateR === undefined) {
                $('.coordinateRE').after('<div>Неверные данные</div>');
            }
            $('#coordinateY').after('<div>Неверные данные</div>');
            return;
        }

        if (coordinateR === undefined) {
            e.preventDefault();
            $('.coordinateRE').after('<div>Неверные данные</div>');
            return;
        }
        $('#checkForm').submit();


    });
});
