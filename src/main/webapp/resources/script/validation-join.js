$(document).ready(() => {
	$('#id').focusout(e => {
		if ($('#id').val() === "") {
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-id').hide();
			$('#id').css('border', 'solid 1px lightgrey');
			$('#id').css('border-bottom', 'none');
		}
	});

	$('#password').focusout(e => {
		if ($('#password').val() === "") {
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
			$('#password').css('border-bottom', 'none');
		}
	});

	$('#name').focusout(e => {
		if ($('#name').val() === "") {
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-name').hide();
			$('#name').css('border', 'solid 1px lightgrey');
			$('#name').css('border-bottom', 'none');
		}
	});

	$('#email').focusout(e => {
		if ($('#email').val() === "") {
			$('#error-msg-email').show();
			$('#email').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-email').hide();
			$('#email').css('border', 'solid 1px lightgrey');
			$('#email').css('border-bottom', 'none');

			const email = $('#email').val();

			if (email.match(/@\w+/) === null) {
				$('#error-msg-email').show();
				$('#email').css('border', 'solid 1px tomato');
			}
		}
	});

	$('#birth1').focusout(e => {
		if ($('#birth1').val() === "") {
			$('#error-msg-birth1').show();
			$('#birth1').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-birth1').hide();
			$('#birth1').css('border', 'solid 1px lightgrey');
			$('#birth1').css('border-bottom', 'none');

			const birth = $('#birth1').val();

			if (birth.match(/\d{6}/) === null) {
				$('#error-msg-birth1').show();
				$('#birth1').css('border', 'solid 1px tomato');
			}
		}
	});

	$('#birth2').focusout(e => {
		if ($('#birth2').val() === "") {
			$('#error-msg-birth2').show();
			$('#birth2').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-birth2').hide();
			$('#birth2').css('border', 'solid 1px lightgrey');
			$('#birth2').css('border-bottom', 'none');

			const birth = $('#birth2').val();

			if (birth.match(/\d{7}/) === null) {
				$('#error-msg-birth2').show();
				$('#birth2').css('border', 'solid 1px tomato');
			}
		}
	});

	$('#telecom').focusout(e => {
		if ($('#telecom').val() === null) {
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-telecom').hide();
			$('#telecom').css('border', 'solid 1px lightgrey');
			$('#telecom').css('border-bottom', 'none');
		}
	});

	$('#phone').focusout(e => {
		if ($('#phone').val() === "") {
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px lightgrey');
		}

		const phone = $('#phone').val();

		if (phone.match(/\d{3}-\d{4}-\d{4}|\d{11}/) === null) {
			$('#error-msg-phone-pattern').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			if (phone.length === 11) {
				const update = `${phone.substr(0, 3)}-${phone.substr(3, 4)}-${phone.substr(7, 4)}`;
				$('#phone').val(update);
			}
			$('#error-msg-phone-pattern').hide();
		}
	});

	$('form').submit(e => {
		e.preventDefault();

		const id = $('#id').val();
		const password = $('#password').val();
		const email = $('#email').val();
		const name = $('#name').val();
		const birth = $('#birth1').val() + "-" + $('#birth2').val();
		const telecom = $('#telecom').val();
		const phone = $('#phone').val();



		// 유효성 검사 
		let isValid = true;

		if (id === "") {
			isValid = false;
			$("#error-msg-iddupl").hide();
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		}
		if (password === "") {
			isValid = false;
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		}
		if (name === "") {
			isValid = false;
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px tomato');
		}
		if (birth === "") {
			isValid = false;
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px tomato');
		}
		if (telecom === null) {
			isValid = false;
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px tomato');
		}
		if (phone === "") {
			isValid = false;
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		}
		if (email === "") {
			isValid = false;
			$('#error-msg-email').show();
			$('#email').css('border', 'solid 1px tomato');
		}

		if (isValid) {
			e.target.submit();
		}
	});
});