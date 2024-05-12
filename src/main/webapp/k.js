const startDateInput = document.getElementById('startDate');
const endDateInput = document.getElementById('endDate');
const resultElement = document.getElementById('result');
const hiddenStartDate = document.getElementById('h-startDate');
const hiddenEndDate = document.getElementById('h-endDate');
const errorMessage = document.querySelector('.incorrect');
const correctMessage = document.querySelector('.correct');
const submitButton = document.querySelector('.btn');

function calculateDuration(event) {
	event.preventDefault();
	let isValid = true;

	const today = new Date();
	today.setHours(0, 0, 0, 0);
	const startDate = new Date(startDateInput.value);
	const endDate = new Date(endDateInput.value);
	const hStart = new Date(hiddenStartDate.value);
	const hEnd = new Date(hiddenEndDate.value);

	if (startDate > endDate) {
		alert('시작 날짜가 종료 날짜보다 이전할 수 없습니다.');
		isValid = false;
	}

	if (startDate < today || endDate < today) {
		alert('오늘 이전 날짜를 선택할 수 없습니다.');
		isValid = false;
	}

	if (startDate.getTime() === endDate.getTime()) {
		alert('같은 날짜를 선택할 수 없습니다.');
		isValid = false;
	}

	if ((startDate >= hStart && startDate < hEnd) || (endDate >= hStart && endDate <= hEnd)) {
		correctMessage.style.display = 'none';
		errorMessage.style.display = 'block';
		isValid = false;
	} else {
		errorMessage.style.display = 'none';
		correctMessage.style.display = 'block';
	}

	const diffInMilliseconds = endDate.getTime() - startDate.getTime();
	const diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);

	resultElement.textContent = `선택한 기간은 ${diffInDays}일입니다.`;

	submitButton.disabled = !isValid;
	if (isValid) {
		event.target.submit();
	}
}

startDateInput.addEventListener('change', calculateDuration);
endDateInput.addEventListener('change', calculateDuration);
