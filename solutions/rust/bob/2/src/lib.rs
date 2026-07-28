pub fn reply(message: &str) -> &str {
    let message = message.trim();

    let is_question = message.ends_with('?');
    let is_yelling =
        message.chars().any(|c| c.is_alphabetic()) && message == message.to_uppercase();

    match (message.is_empty(), is_yelling, is_question) {
        (true, ..) => "Fine. Be that way!",
        (_, true, true) => "Calm down, I know what I'm doing!",
        (_, true, false) => "Whoa, chill out!",
        (_, false, true) => "Sure.",
        (_, false, false) => "Whatever.",
    }
}
