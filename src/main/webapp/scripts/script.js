function clicked(event) {

    if ($('input[name="coordinateR"]:checked').prop("checked")) {

        let svg = document.querySelector('svg');
        let r = $('input[name="coordinateR"]:checked').val();
        let rect = event.currentTarget.getBoundingClientRect();
        let coordinateX = event.clientX - rect.left;
        let coordinateY = event.clientY - rect.top;
        let basis = 100 / r;
        let x = ((coordinateX - 150) / basis).toFixed(2);
        let y = ((150 - coordinateY) / basis).toFixed(2);
        svg.insertAdjacentHTML("beforeend", `<circle r="3" cx="${coordinateX}" cy="${coordinateY}" fill-opacity="0.7" fill="red" stroke="firebrick"></circle>`);

        let form = document.createElement('form');
        form.action = "/web-lab-2-1.0/controller";
        form.method = 'POST';

        form.innerHTML = (`<input type="hidden" name="coordinateX" value="${x}"> 
                           <input type="hidden" name="coordinateY" value="${y}"> 
                           <input type="hidden" name="coordinateR" value="${r}">`);
        document.body.append(form);
        form.submit();
    } else {
        $('.coordinateRE').next("div").remove();
        $('.coordinateRE').after('<div>Выберите R</div>');
    }
}

$(function () {
    let x = $("#tableWithResults tr:last td[class='x']").attr("id");
    let y = $("#tableWithResults tr:last td[class='y']").attr("id");
    let r = $("#tableWithResults tr:last td[class='r']").attr("id");
    let coordinateX = x * 100 / r + 150;
    let coordinateY = 150 - y * 100 / r;

    let svg = document.querySelector('svg');
    svg.insertAdjacentHTML("beforeend", `<circle r="3" cx="${coordinateX}" cy="${coordinateY}" fill-opacity="0.7" fill="red" stroke="firebrick"></circle>`);
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
