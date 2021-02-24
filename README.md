# leetcode
## 环境搭建(IDEA)
### 1. 下载 leetcode editor 插件
### 2. Prefrences -> Tools -> leetcode plugins 中配置

```aidl
P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
```

```aidl
${question.content}
package leetcode.editor.cn;
//java:${question.title}
public class P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    
    public static void main(String[] args){
        Solution solution = new P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
    ${question.code}
}
```

```aidl
${question.title}	question title	ex:Two Sum
${question.titleSlug}	question title slug 	ex:two-sum
${question.frontendQuestionId}	question serial number
${question.content}	question content
${question.code}	question code
$!velocityTool.camelCaseName(str)	transform str camel case
$!velocityTool.snakeCaseName(str)	transform str snake case
$!velocityTool.leftPadZeros(str,n)	pad sting with zero make str length at least n.
$!velocityTool.date()	The current time
```