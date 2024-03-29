#
# NOTE: THIS DOCKERFILE IS GENERATED VIA "apply-templates.sh"
#
# PLEASE DO NOT EDIT IT DIRECTLY.
#

FROM oraclelinux:7-slim

RUN set -eux; \
# https://unix.stackexchange.com/a/477127/153467
	yum install -y --setopt=skip_missing_names_on_install=False \
		gzip \
		tar \
		\
# jlink --strip-debug on 13+ needs objcopy: https://github.com/docker-library/openjdk/issues/351
# Error: java.io.IOException: Cannot run program "objcopy": error=2, No such file or directory
		binutils \
# java.lang.UnsatisfiedLinkError: /usr/java/openjdk-12/lib/libfontmanager.so: libfreetype.so.6: cannot open shared object file: No such file or directory
# https://github.com/docker-library/openjdk/pull/235#issuecomment-424466077
		freetype fontconfig \
	; \
	rm -rf /var/cache/yum

ENV JAVA_HOME /usr/java/openjdk-20
ENV PATH $JAVA_HOME/bin:$PATH

# Default to UTF-8 file.encoding
ENV LANG en_US.UTF-8

# https://jdk.java.net/
# >
# > Java Development Kit builds, from Oracle
# >
ENV JAVA_VERSION 20-ea+26

RUN set -eux; \
	\
	arch="$(objdump="$(command -v objdump)" && objdump --file-headers "$objdump" | awk -F '[:,]+[[:space:]]+' '$1 == "architecture" { print $2 }')"; \
	case "$arch" in \
		'i386:x86-64') \
			downloadUrl='https://download.java.net/java/early_access/jdk20/26/GPL/openjdk-20-ea+26_linux-x64_bin.tar.gz'; \
			downloadSha256='70075a76ed683898d8d71852394c88ab73d8665b15accfafa85dac3be5fbf87e'; \
			;; \
		'aarch64') \
			downloadUrl='https://download.java.net/java/early_access/jdk20/26/GPL/openjdk-20-ea+26_linux-aarch64_bin.tar.gz'; \
			downloadSha256='041c2b0e7b68e58376d8b03db365434ceecd65671de20af28e6c32f47ccde94a'; \
			;; \
		*) echo >&2 "error: unsupported architecture: '$arch'"; exit 1 ;; \
	esac; \
	\
	curl -fL -o openjdk.tgz "$downloadUrl"; \
	echo "$downloadSha256 *openjdk.tgz" | sha256sum --strict --check -; \
	\
	mkdir -p "$JAVA_HOME"; \
	tar --extract \
		--file openjdk.tgz \
		--directory "$JAVA_HOME" \
		--strip-components 1 \
		--no-same-owner \
	; \
	rm openjdk.tgz*; \
	\
	rm -rf "$JAVA_HOME/lib/security/cacerts"; \
# see "update-ca-trust" script which creates/maintains this cacerts bundle
	ln -sT /etc/pki/ca-trust/extracted/java/cacerts "$JAVA_HOME/lib/security/cacerts"; \
	\
# https://github.com/oracle/docker-images/blob/a56e0d1ed968ff669d2e2ba8a1483d0f3acc80c0/OracleJava/java-8/Dockerfile#L17-L19
	ln -sfT "$JAVA_HOME" /usr/java/default; \
	ln -sfT "$JAVA_HOME" /usr/java/latest; \
	for bin in "$JAVA_HOME/bin/"*; do \
		base="$(basename "$bin")"; \
		[ ! -e "/usr/bin/$base" ]; \
		alternatives --install "/usr/bin/$base" "$base" "$bin" 20000; \
	done; \
	\
# https://github.com/docker-library/openjdk/issues/212#issuecomment-420979840
# https://openjdk.java.net/jeps/341
	java -Xshare:dump; \
	\
# basic smoke test
	fileEncoding="$(echo 'System.out.println(System.getProperty("file.encoding"))' | jshell -s -)"; [ "$fileEncoding" = 'UTF-8' ]; rm -rf ~/.java; \
	javac --version; \
	java --version

# "jshell" is an interactive REPL for Java (see https://en.wikipedia.org/wiki/JShell)
#CMD ["jshell"]

RUN yum -y install vim
RUN touch ~/.bashrc
# PS1 settings. split echo because of '#' error
RUN echo -e "# set variable identifying the chroot you work in (used in the prompt below)\n\
if [ -z \"\${debian_chroot:-}\" ] && [ -r /etc/debian_chroot ]; then\n\
	debian_chroot=\$(cat /etc/debian_chroot)\n\
fi\n" \
>> ~/.bashrc
RUN echo -e "# set a fancy prompt (non-color, unless we know we \"want\" color)\n\
case \"\$TERM\" in\n\
	xterm-color|*-256color) color_prompt=yes;;\n\
esac\n" \
>> ~/.bashrc
RUN echo -e "# uncomment for a colored prompt, if the terminal has the capability; turned" >> ~/.bashrc
RUN echo -e "# off by default to not distract the user: the focus in a terminal window" >> ~/.bashrc
RUN echo -e "# should be on the output of commands, not on the prompt\n" >> ~/.bashrc
RUN echo -e "force_color_prompt=yes\n" >> ~/.bashrc
RUN echo -e "# We have color support; assume it's compliant with Ecma-48" >> ~/.bashrc
RUN echo -e "# (ISO/IEC-6429). (Lack of such support is extremely rare, and such" >> ~/.bashrc
RUN echo -e "# (ISO/IEC-6429). (Lack of such support is extremely rare, and such" >> ~/.bashrc
RUN echo -e "if [ -n \"\$force_color_prompt\" ]; then\n\
	if [ -x /usr/bin/tput ] && tput setaf 1 >&/dev/null; then\n\
	color_prompt=yes\n\
	else\n\
	color_prompt=\n\
	fi\n\
fi\n\
\n\
if [ \"\$color_prompt\" = yes ]; then\n\
	PS1='\${debian_chroot:+(\$debian_chroot)}\[\\033[01;32m\]\u@\h\[\\033[00m\]:\[\\033[01;36m\]\w\[\\033[00m\]\\n\[\\033[01;33m\]$\[\\033[00m\] '\n\
else\n\
	PS1='\${debian_chroot:+(\$debian_chroot)}\u@\h:\w\\\$ '\n\
fi\n\
unset color_prompt force_color_prompt\n" \
>> ~/.bashrc
RUN echo -e "# If this is an xterm set the title to user@host:dir\n\
case \"\$TERM\" in\n\
xterm*|rxvt*)\n\
	PS1=\"\[\\e]0;\${debian_chroot:+(\$debian_chroot)}\u@\h: \w\\a\]\$PS1\"\n\
	;;\n\
*)\n\
	;;\n\
esac\n" \
>> ~/.bashrc
# alias
RUN echo -e "alias ls=\"ls --color=auto\"\n\
alias ll=\"ls -alF --color=auto\"\n\
alias vi=\"vim\"" \
>> ~/.bashrc
# .vimrc
RUN echo -e "set nu\n\
set ai\n\
set si\n\
set cindent\n\
set sts=4\n\
set ts=4\n\
set shiftwidth=4\n\
set wmnu\n\
set laststatus=2\n\
set ignorecase\n\
set hlsearch\n\
set nocompatible\n\
set ruler\n\
set fileencodings=utf-8,euc-kr\n\
set fencs=ucs-bom,utf-8,euc-kr\n\
set showmatch\n\
syntax on\n\
filetype indent on\n\
set bs=indent,eol,start\n\
set title\n\
color evening\n" \
> ~/.vimrc
RUN source ~/.bashrc
RUN mkdir /root/project
CMD ["bash"]
