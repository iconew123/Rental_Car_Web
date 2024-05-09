const startDateInput = document.getElementById('startDate');
const endDateInput = document.getElementById('endDate');
const resultElement = document.getElementById('result');
const calculateButton = document.getElementById('calculate-button');

calculateButton.addEventListener('click', () => {
  const startDate = new Date(startDateInput.value);
  const endDate = new Date(endDateInput.value);

  if (startDate > endDate) {
    alert('시작 날짜가 종료 날짜보다 이전할 수 없습니다.');
    return;
  }

  const diffInMilliseconds = endDate.getTime() - startDate.getTime();
  const diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);

  resultElement.textContent = `선택한 기간은 ${diffInDays}일입니다.`;
});
