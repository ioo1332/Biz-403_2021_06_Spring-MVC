document.addEventListener("DOMContentLoaded", () => {
  document.querySelector("#menu").addEventListener("click", (e) => {
    let text = e.target.textContent;
    let url = `${rootPath}`;

    if (text === "공지사항") {
      url += "/notice/board";
    } else if (text === "정보게시판") {
      url += "/info";
    } else if (text === "생활 TIP") {
      url += "/tip";
    } else if (text === "랜선집들이") {
      url += "/interior";
    } else if (text === "혼잘TALK") {
      url += "/talk";
    } else if (text === "리뷰게시판") {
      url += "/review";
    } else if (text === "자취 Q&A") {
      url += "/qna";
    }

    location.href = url;
  });
});
